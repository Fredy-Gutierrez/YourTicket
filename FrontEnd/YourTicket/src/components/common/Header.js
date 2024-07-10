import React from "react";
import { Link, useNavigate } from "react-router-dom";

const Header = ({ isLoggedIn, onLogout }) => {
  const navigate = useNavigate();

  const handleLogout = () => {
    onLogout();
    navigate("/login");
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">
          YourTicket
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            {isLoggedIn ? (
              <>
                <li className="nav-item">
                  <Link className="nav-link" to="/ordenes">
                    Ordenes
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/usuarios">
                    Usuarios
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/vendedores">
                    Vendedores
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/clientes">
                    Clientes
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/eventos">
                    Eventos
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/zonas">
                    Zonas
                  </Link>
                </li>
                <li className="nav-item">
                  <button
                    className="btn btn-link nav-link"
                    onClick={handleLogout}
                  >
                    Cerrar Sesión
                  </button>
                </li>
              </>
            ) : (
              <li className="nav-item">
                <Link
                  className="btn btn-primary nav-link text-white"
                  to="/login"
                >
                  Iniciar Sesión
                </Link>
              </li>
            )}
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Header;
