export interface ButonCurseProps {
  type: string;
  content: string;
}

export interface ICurso {
  id: number;
  nombre: string;
  descripcion: string;
  lenguaje: string;
  lecciones: ILeccion[];
}

export interface ILeccion {
  id: number;
  nombre: string;
  autor: string;
  puntuacionPositiva: number;
  puntuacionNegativa: number;
}
