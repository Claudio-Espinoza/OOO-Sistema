import axios from 'axios';
import { ICurso, ILeccion } from '@/model/Course.ts';

class RankingService {
  private API_URL = 'http://localhost:8080';

  async fetchAllCourse(): Promise<Array<ICurso> | null> {
    try {
      const response = await axios.get(`${this.API_URL}/curso/temas`);
      const course: Array<ICurso> | undefined = response.data;

      if (course && course.length > 0) {
        return course;
      } else {
        console.log('No se encontraron niveles');
        return null;
      }
    } catch (error) {
      console.error(error);
      return null;
    }
  }

  async fetchLectionForCourse(
    id: string | string[]
  ): Promise<Array<ILeccion> | null> {
    try {
      const response = await axios.get(`${this.API_URL}/leccion/curso/${id}`);
      const course: Array<ILeccion> | undefined = response.data;

      if (course && course.length > 0) {
        return course;
      } else {
        console.log('No se encontraron niveles');
        return null;
      }
    } catch (error) {
      console.error(error);
      return null;
    }
  }
}

export default RankingService;
