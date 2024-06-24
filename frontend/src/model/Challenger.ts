// CardDescription
export interface CardDescription {
  title: string;
  course: string;
  type: string;
}

// CardInformationProps
export interface ArticleInformationProps {
  title: string;
  subTitle: string;
  review: string;
  autor: string;
  type: string;
}

// ArticleSection.vue
export interface ArticleSectionProps {
  title: string;
  subTitle: string;
  review: string;
  autor: string;
  type: string;
  description: string;
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
}

export interface ButonFilterProps {
  content: string;
  state: boolean;
}
