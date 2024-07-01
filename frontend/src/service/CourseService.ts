import axios from 'axios';
import { Ref, ref } from 'vue';
import { ICurso } from '@/model/Course.ts';

class RankingService {
  private API_URL = 'http://localhost:8080';
  private courseData: Ref<Array<ICurso>>;

  constructor() {
    this.courseData = ref<Array<ICurso>>([]);
  }

  async fetchAllCourse(): Promise<Array<ICurso> | null> {
    try {
      const response = await axios.get(`${this.API_URL}/curso/temas`);
      const course: Array<ICurso> | undefined = response.data;

      if (course && course.length > 0) {
        this.courseData.value = course;
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
