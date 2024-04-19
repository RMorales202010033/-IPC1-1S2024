import React, { useState, useEffect, Fragment } from 'react';
import './Styles/Login.css';
import { useCookies } from 'react-cookie';
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import PieChartReport from './PieChart';
import ReporteBar from './Barchart';

function Usuario() {
    // Se declaran los estados iniciales
    const [lista, setLista] = useState([]);
    // Se declaran las cookies, aunque no se usen algunos, se deben poner, sino tira error y no reconoce el removeCookie 
    const [cookies, setCookie, removeCookie] = useCookies(['usuario']);
    const navigate = useNavigate();

    // Obtenemos los datos que servirán para hacer el reporte y lo guardamos en un useState
    useEffect(() => {
        fetch(`http://localhost:5000/reportes`, {
            method: "GET",
        })
            .then((response) => response.json())
            .then((res) => {
                console.log(res)
                setLista(res.response)
            })
            .catch((error) => console.error(error));
    }, []);

    // Este método se encarga de hacer logout
    const handleLogout = () => {
        removeCookie('usuario');
        navigate('/login')
    };

    return (
        <Fragment>
            <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "100%", top: "0", backgroundColor: "#212529", position: "sticky", zIndex:"1000" }}>
                <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "50%", top: 0, paddingLeft: "5%" }}>
                    <ul style={{ listStyleType: "none", display: "flex", padding: 0, height: "100%", alignItems: "center", margin: "0px" }}>
                        <li style={{ color: "white", marginRight: "35px" }}>
                            {/* El link nos ayuda a navegar entre componentes, parecido al navigate */}
                            <Link style={{ color: "white", textDecoration: "none" }} to="/user">
                                Home
                            </Link>
                        </li>
                        <li style={{ color: "white", marginRight: "35px" }}>
                            <Link style={{ color: "white", textDecoration: "none" }} to="/createPost">
                                Create post
                            </Link>
                        </li>
                        {/* Nuevo apartado para ver reportes */}
                        <li style={{ color: "white" }}>
                            <Link style={{ color: "white", textDecoration: "none" }} to="/reports">
                                Reports
                            </Link>
                        </li>
                    </ul>
                </div>
                <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "50%", top: 0, flexDirection: "row-reverse", paddingRight: "5%" }}>
                    <button className="btn btn-outline-info" onClick={handleLogout}>
                        Logout
                    </button>
                </div>
            </div>
            <div style={{ height: "auto", width: "100%", top: "10", paddingTop: "5%", paddingRight: "20%", paddingLeft: "20%" }}>
                <div style={{ display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center" }}>
                    {
                        // Colocamos de primero la gráfica de pie
                        <PieChartReport />
                    }
                    {
                        // Colocamos el gráfico de barras, pero en este caso al hijo le pasaremos atributos del padre
                        // osea en este caso le mandaremos la lista de datos desde el padre y el hijo podrá usar estos
                        // valores por medio de las props
                        <ReporteBar BarData={lista} />
                    }
                </div>
            </div>
        </Fragment>
    );
}

export default Usuario;