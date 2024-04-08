import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from '../Login';
import Admin from '../Admin';

function Router() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Creación de las distintas rutas que se tendrán (urls) y el componente que se llamará */}
                <Route path='/' element={<Navigate to="/login" />} />
                <Route path='/login' element={<Login/>} />
                <Route path='/admin' element={<Admin/>} />
            </Routes>
        </BrowserRouter>
    );
}

export default Router;