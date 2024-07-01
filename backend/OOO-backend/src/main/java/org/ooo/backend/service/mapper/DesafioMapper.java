package org.ooo.backend.service.mapper;


import org.ooo.backend.model.Desafio;
import org.ooo.backend.model.dto.DesafioDto;

public class DesafioMapper {

    public static Desafio toDesafio(DesafioDto desafioDto){
        Desafio desafio = new Desafio();

        desafio.setAutor(desafioDto.getAutor());
        desafio.setNombre(desafioDto.getNombre());
        desafio.setPuntuacionNegativa(desafioDto.getPuntuacionNegativa());
        desafio.setPuntuacionPositiva(desafioDto.getPuntuacionPositiva());

        return desafio;
    }


    public static DesafioDto fromDesafio(Desafio desafio){
        DesafioDto desafioDto = new DesafioDto();

        desafioDto.setIdCurso(desafio.getCurso().getId());
        desafioDto.setAutor(desafio.getAutor());
        desafioDto.setNombre(desafio.getNombre());
        desafioDto.setPuntuacionPositiva(desafio.getPuntuacionPositiva());
        desafioDto.setPuntuacionNegativa(desafio.getPuntuacionNegativa());
        desafioDto.setDireccionPdfContenido(desafio.getDireccionPdfContenido());

        return desafioDto;
    }
}
