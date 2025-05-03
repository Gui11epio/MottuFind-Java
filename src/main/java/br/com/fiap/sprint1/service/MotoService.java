package br.com.fiap.sprint1.service;

import br.com.fiap.sprint1.dto.MotoRequest;
import br.com.fiap.sprint1.dto.MotoResponse;
import br.com.fiap.sprint1.model.Moto;
import br.com.fiap.sprint1.model.Patio;
import br.com.fiap.sprint1.model.TagRfid;
import br.com.fiap.sprint1.repository.MotoRepository;
import br.com.fiap.sprint1.repository.PatioRepository;
import br.com.fiap.sprint1.repository.TagRfidRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotoService {
    private final MotoRepository motoRepository;
    private final PatioRepository patioRepository;
    private final TagRfidRepository tagRfidRepository;
    private final ModelMapper modelMapper;

    @CachePut(value = "motos", key = "#dto.placa")
    public MotoResponse criarMoto(MotoRequest dto) {
        Moto moto = modelMapper.map(dto, Moto.class);

        Patio patio = patioRepository.findById(dto.getPatioId())
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));

        if (motoRepository.existsById(dto.getPlaca())) {
            throw new IllegalArgumentException("Moto já cadastrada com esta placa");
        }

        // Criação automática da tag
        TagRfid tag = new TagRfid();
        tag.setCodigoIdentificacao("TAG-" + dto.getPlaca()); // ou UUID.randomUUID().toString()
        tag.setAtiva(true);

        moto.setPatio(patio);
        moto.setTag(tag);
        tag.setMoto(moto);

        Moto saved = motoRepository.save(moto); // salva moto + tag em cascata
        return modelMapper.map(saved, MotoResponse.class);
    }

    public Page<MotoResponse> listarMotos(Pageable pageable) {
        return motoRepository.findAll(pageable)
                .map(moto -> modelMapper.map(moto, MotoResponse.class));
    }

    @Cacheable(value = "motos", key = "#placa")
    public MotoResponse buscarPorPlaca(String placa) {
        Moto moto = motoRepository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));
        return modelMapper.map(moto, MotoResponse.class);
    }

    @CachePut(value = "motos", key = "#placa")
    public MotoResponse atualizarMoto(String placa, MotoRequest dto) {
        Moto moto = motoRepository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("Moto não encontrada"));

        Patio patio = patioRepository.findById(dto.getPatioId())
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));

        TagRfid tag = tagRfidRepository.findById(dto.getTagId())
                .orElseThrow(() -> new EntityNotFoundException("Tag RFID não encontrada"));

        moto.setModelo(dto.getModelo());
        moto.setMarca(dto.getMarca());
        moto.setStatus(dto.getStatus());
        moto.setPatio(patio);
        moto.setTag(tag);

        Moto atualizado = motoRepository.save(moto);
        return modelMapper.map(atualizado, MotoResponse.class);
    }

    @CacheEvict(value = "motos", key = "#placa")
    public void deletarMoto(String placa) {
        if (!motoRepository.existsById(placa)) {
            throw new EntityNotFoundException("Moto não encontrada");
        }
        motoRepository.deleteById(placa);
    }
}
