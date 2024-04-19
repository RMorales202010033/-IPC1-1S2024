import React, { useEffect, useRef, useState } from 'react';
import Chart from 'chart.js/auto';

// Se coloca props en la función de creación de nuestro componente, estas props reciben todos los valores que se manden
//desde el padre
const ReporteBar = (props) => {
    const chartRef = useRef(null); // Creamos una referencia mutable para el elemento canvas
    const [lista, setLista] = useState([]);

    useEffect(() => {
        setLista(props.BarData); // Actualizamos la lista cuando las props cambien
    }, [props.BarData]);

    useEffect(() => {
        // Función que se ejecuta cada vez que cambia la lista de datos
        if (lista.length === 0) return; // Si la lista está vacía, no hacemos nada

        // Extraemos los nombres de usuario y la cantidad de posts de la lista de datos
        const labels = lista.map(item => item.usuario);
        const data = lista.map(item => item.post);

        // Creamos un arreglo de colores para cada barra
        const colors = ['#FF6384', '#36A2EB', '#FFCE56', '#4BC0C0', '#9966FF', '#FF9F40', '#32a852', '#ff7f0e', '#d62728', '#9467bd'];

        // Configuración de la gráfica de barras
        const config = {
            type: 'bar', // Tipo de gráfica
            data: {
                labels: labels, // Nombres de usuario en el eje X
                datasets: [{
                    label: 'Cantidad de Posts por Usuario', // Etiqueta de la serie de datos
                    data: data, // Cantidad de posts en el eje Y
                    backgroundColor: colors.slice(0, data.length), // Colores para las barras
                    borderColor: 'rgba(54, 162, 235, 1)', // Color del borde de las barras
                    borderWidth: 1 // Ancho del borde de las barras
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true // Empezar el eje Y desde cero
                    }
                }
            }
        };

        // Creamos una instancia de Chart.js en el elemento canvas utilizando la configuración
        const myChart = new Chart(chartRef.current, config);

        // Devolvemos una función de limpieza que se ejecutará cuando el componente se desmonte
        return () => myChart.destroy();
    }, [lista]);

    // Renderizamos el elemento canvas que se utilizará para la gráfica
    return (
        <div style={{ width: "400 px", height: "400px", marginBottom: "5%" }}>
            <canvas ref={chartRef} style={{ width: "100%", height: "100%" }}></canvas>
        </div>
    );
};

export default ReporteBar;