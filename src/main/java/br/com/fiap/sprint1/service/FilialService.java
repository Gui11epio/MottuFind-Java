package br.com.fiap.sprint1.service;

import br.com.fiap.sprint1.dto.FilialRequest;
import br.com.fiap.sprint1.dto.FilialResponse;
import br.com.fiap.sprint1.model.Filial;
import br.com.fiap.sprint1.repository.FilialRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilialService {

    private final FilialRepository filialRepository;
    private final ModelMapper modelMapper;


    public FilialResponse criar(FilialRequest dto) {
        Filial filial = modelMapper.map(dto, Filial.class);
        filial = filialRepository.save(filial);
        return modelMapper.map(filial, FilialResponse.class);
    }

    public Page<FilialResponse> listar(Pageable pageable) {
        return filialRepository.findAll(pageable)
                .map(f -> modelMapper.map(f, FilialResponse.class));
    }

    @Cacheable(value = "filiais", key = "#id")
    public FilialResponse buscarPorId(Long id) {
        Filial filial = filialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filial não encontrada"));
        return modelMapper.map(filial, FilialResponse.class);
    }

    @CachePut(value = "filiais", key = "#id")
    public FilialResponse atualizar(Long id, FilialRequest dto) {
        Filial filial = filialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filial não encontrada"));

        filial.setNome(dto.getNome());
        filial.setCidade(dto.getCidade());
        filial.setPais(dto.getPais());

        filial = filialRepository.save(filial);
        return modelMapper.map(filial, FilialResponse.class);
    }

    @CacheEvict(value = "filiais", key = "#id")
    public void deletar(Long id) {
        if (!filialRepository.existsById(id)) {
            throw new EntityNotFoundException("Filial não encontrada");
        }
        filialRepository.deleteById(id);
    }
}
