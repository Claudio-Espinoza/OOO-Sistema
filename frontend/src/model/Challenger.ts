// CardDescription
export interface CardDescription {
  title?: string;
  subTitle?: string;
  autor?: string;
  type: string;
  description: string;
  negativePoint: number;
  positivePoint: number;
  direccion_pdf_contenido: string;
}

// CardInformationProps ArticleInformationProps
export interface ArticleInformationProps {
  id: number;
  title?: string;
  subTitle?: string;
  autor?: string;
  type: string;
  description: string;
  negativePoint: number;
  positivePoint: number;
  direccion_pdf_contenido: string;
}

// ArticleSection.vue
export interface ArticleSectionProps {
  id: number;
  title: string;
  subTitle: string;
  autor: string;
  type: string;
  description: string;
  negativePoint: number;
  positivePoint: number;
  direccion_pdf_contenido: string;
}

// SectionDescription
export interface ArticleDescriptionProps {
  description: string;
}

// ChallengerCard.vue
export interface ChallengerCardProps {
  title?: string;
  course?: string;
  type?: string;
  id?: string;
}

export interface ButonFilterProps {
  content: string;
  state: boolean;
}

export interface IChallenger {
  id: number;
  type: string;
  nombreCurso: string;
  nombre: string;
  autor: string;
  puntuacion_positiva: number;
  puntuacion_negativa: number;
  id_curso: number;
  direccion_pdf_contenido: string;
  descripcion: string;
}
