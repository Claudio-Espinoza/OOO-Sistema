import { IChallenger } from './../model/Challenger';
import axios from 'axios';

class RankingService {
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
}

const descargarPDF = async (idDesafio: number) => {
  try {
    const response = await axios.get(
      `http://localhost:8080/descargar-pdf/${idDesafio}`,
      {
        responseType: 'blob', // Importante para tratar la respuesta como un archivo binario
      }
    );

    // Crear un URL temporal para el archivo
    const url = window.URL.createObjectURL(new Blob([response.data]));

    // Crear un enlace para descargar el archivo
    const link = document.createElement('a');
    link.href = url;
    link.setAttribute('download', `desafio-${idDesafio}.pdf`); // Nombre del archivo PDF a descargar
    document.body.appendChild(link);

    // Disparar la descarga
    link.click();

    // Limpiar el enlace temporal después de la descarga
    if (link.parentNode) {
      link.parentNode.removeChild(link);
    }
    window.URL.revokeObjectURL(url);
  } catch (error) {
    console.error('Hubo un error al descargar el PDF:', error);
  }
};

export default RankingService;
