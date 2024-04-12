import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from '../Login';
import Admin from '../Admin';
import Usuario from '../Usuario';
import CreatePost from '../CreatePost';

function Router() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Creación de las distintas rutas que se tendrán (urls) y el componente que se llamará */}
                <Route path='/' element={<Navigate to="/login" />} />
                <Route path='/login' element={<Login/>} />
                <Route path='/admin' element={<Admin/>} />
                <Route path='/user' element={<Usuario/>} />
                <Route path='/createPost' element={<CreatePost/>} />
            </Routes>
        </BrowserRouter>
    );
}

export default Router;