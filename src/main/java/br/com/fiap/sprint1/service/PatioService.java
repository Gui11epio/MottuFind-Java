package br.com.fiap.sprint1.service;

import br.com.fiap.sprint1.dto.PatioRequest;
import br.com.fiap.sprint1.dto.PatioResponse;
import br.com.fiap.sprint1.model.Filial;
import br.com.fiap.sprint1.model.Patio;
import br.com.fiap.sprint1.repository.FilialRepository;
import br.com.fiap.sprint1.repository.PatioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatioService {

    private final PatioRepository patioRepository;
    private final FilialRepository filialRepository;
    private final ModelMapper modelMapper;

    public PatioResponse criar(PatioRequest dto) {
        Patio patio = new Patio();
        patio.setNome(dto.getNome());
        patio.setLargura(dto.getLargura());
        patio.setComprimento(dto.getComprimento());

        Filial filial = filialRepository.findById(dto.getFilialId())
                .orElseThrow(() -> new EntityNotFoundException("Filial não encontrada"));
        patio.setFilial(filial);

        patio = patioRepository.save(patio);
        return modelMapper.map(patio, PatioResponse.class);
    }

    public Page<PatioResponse> listar(Pageable pageable) {
        return patioRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, PatioResponse.class));
    }

    public PatioResponse buscarPorId(Long id) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));
        return modelMapper.map(patio, PatioResponse.class);
    }

    public PatioResponse atualizar(Long id, PatioRequest dto) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pátio não encontrado"));

        Filial filial = filialRepository.findById(dto.getFilialId())
                .orElseThrow(() -> new EntityNotFoundException("Filial não encontrada"));

        patio.setNome(dto.getNome());
        patio.setLargura(dto.getLargura());
        patio.setComprimento(dto.getComprimento());
        patio.setFilial(filial);

        patio = patioRepository.save(patio);
        return modelMapper.map(patio, PatioResponse.class);
    }

    public void deletar(Long id) {
        if (!patioRepository.existsById(id)) {
            throw new EntityNotFoundException("Pátio não encontrado");
        }
        patioRepository.deleteById(id);
    }
}
