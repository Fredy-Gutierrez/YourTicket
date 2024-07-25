import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import Login from "./components/auth/Login";
import Home from "./components/pages/Home";
import Ordenes from "./components/pages/Ordenes";
import Usuarios from "./components/pages/Usuarios";
import Vendedores from "./components/pages/Vendedores";
import Clientes from "./components/pages/Clientes";
import Eventos from "./components/pages/Eventos";
import Zonas from "./components/pages/Zonas";
import Header from "./components/common/Header";
import Footer from "./components/common/Footer";
import Acerca from "./components/pages/About";
import Contacto from "./components/pages/Contact";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const loggedIn = localStorage.getItem("isLoggedIn") === "true";
    setIsLoggedIn(loggedIn);
  }, []);

  const handleLoginSuccess = () => {
    setIsLoggedIn(true);
    localStorage.setItem("isLoggedIn", "true");
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    localStorage.removeItem("isLoggedIn");
  };

  return (
    <Router>
      <Header isLoggedIn={isLoggedIn} onLogout={handleLogout} />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route
          path="/login"
          element={isLoggedIn ? <Navigate to="/" /> : <Login onLoginSuccess={handleLoginSuccess} />}
        />
        <Route
          path="/ordenes"
          element={isLoggedIn ? <Ordenes /> : <Navigate to="/login" />}
        />
        <Route
          path="/usuarios"
          element={isLoggedIn ? <Usuarios /> : <Navigate to="/login" />}
        />
        <Route
          path="/vendedores"
          element={isLoggedIn ? <Vendedores /> : <Navigate to="/login" />}
        />
        <Route
          path="/clientes"
          element={isLoggedIn ? <Clientes /> : <Navigate to="/login" />}
        />
        <Route
          path="/eventos"
          element={isLoggedIn ? <Eventos /> : <Navigate to="/login" />}
        />
        <Route
          path="/zonas"
          element={isLoggedIn ? <Zonas /> : <Navigate to="/login" />}
        />
        <Route path="/acerca" element={<Acerca />} />
        <Route path="/contacto" element={<Contacto />} />
        <Route
          path="*"
          element={<Navigate to={isLoggedIn ? "/ordenes" : "/"} />}
        />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
