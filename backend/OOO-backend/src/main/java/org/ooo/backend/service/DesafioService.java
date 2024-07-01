package org.ooo.backend.service;

import lombok.RequiredArgsConstructor;
import org.ooo.backend.model.Desafio;
import org.ooo.backend.model.dto.DesafioDto;
import org.ooo.backend.repository.CursoRepository;
import org.ooo.backend.repository.DesafioRespository;
import org.ooo.backend.service.mapper.DesafioMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesafioService {

    private final DesafioRespository desafioRespository;
    private final CursoRepository cursoRepository;

    private final String pathFolderPDF = "desafios/";



    public List<Desafio> obtenerTodosLosDesafios(){

        List<Desafio> desafios = desafioRespository.findAll();

        if (!desafios.isEmpty()) {
            return desafios;
        } else {
            throw new NoSuchElementException("No se encontraron desafios");
        }

    }

    public List<Desafio> obtenerTodosLosDesafioPorCurso(int idCurso) {

        List<Desafio> desafios = desafioRespository.findAllByCursoId(idCurso);

        if (!desafios.isEmpty()) {
            return desafios;
        } else {
            throw new NoSuchElementException("No se encontraron desafios");
        }

    }

    public void agregaPuntuacionDesafio(int idDesafio, boolean positiva) {
        Optional<Desafio> desafio = desafioRespository.findById(idDesafio);

        if (desafio.isPresent()) {
            Desafio desafioTemporal = desafio.get();
            if (positiva) {
                desafioTemporal.setPuntuacionPositiva(desafioTemporal.getPuntuacionPositiva() + 1);
            } else {
                desafioTemporal.setPuntuacionNegativa(desafioTemporal.getPuntuacionNegativa() + 1);
            }
            desafioRespository.save(desafioTemporal);
        } else {
            throw new NoSuchElementException("No se encontro el desafio");
        }
    }

    public void agregarDesafio(DesafioDto desafioDto, MultipartFile file){

        Desafio desafio = DesafioMapper.toDesafio(desafioDto);

        Path direccionContenidoPdf = guardarContenidoDesafioPdf(file);

        desafio.setDireccionPdfContenido(direccionContenidoPdf.toString());

        desafio.setCurso(cursoRepository.findById(desafioDto.getIdCurso())
                .orElseThrow(() -> new NoSuchElementException("Desafio no encontrado con ID: " + desafioDto.getIdCurso())));

        desafioRespository.save(desafio);
    }

    private Path guardarContenidoDesafioPdf(MultipartFile file){

        try {
            Path path = Paths.get(pathFolderPDF, file.getOriginalFilename());
            Files.copy(file.getInputStream(), path);

            return path;
        }catch (Exception e){
            throw new RuntimeException("Ha ocurrido un error al guardar el PDF");
        }


    }




}