import { IChallenger } from './../model/Challenger';
import axios from 'axios';

class ChallengerService {
  private API_URL = 'http://localhost:8080';

  async fetchAllChallenger(): Promise<Array<IChallenger> | null> {
    try {
      const response = await axios.get(`${this.API_URL}/desafio/todos`);
      const course: Array<IChallenger> | undefined = response.data;

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

  async deleteChallenger(idDesafio: number): Promise<void> {
    try {
      await axios.delete(`${this.API_URL}/desafio/${idDesafio}`);
      console.log('Desafío eliminado correctamente');
    } catch (error) {
      console.error('Error al eliminar el desafío:', error);
    }
  }
}

export default new ChallengerService();
