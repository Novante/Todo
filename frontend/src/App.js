import logo from './logo.svg';
import './App.css';
import Homepage from "./pages/Homepage";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import 'antd/dist/antd.css';


function App() {


    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Homepage />}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
