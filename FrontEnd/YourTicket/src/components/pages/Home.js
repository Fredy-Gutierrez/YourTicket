import React from "react";
import exclusiveEvent from "../../assets/images/Evento-Exclusivo.png";
import secureShopping from "../../assets/images/compra-segura.png";
import customerSupport from "../../assets/images/soporte.png";

const Home = () => {
  return (
    <div
      className="home-container container mt-3"
      style={{ minHeight: "80vh" }}
    >
      <div className="text-center mb-4">
        <h1 className="display-4 font-weight-bold text-primary">
          Bienvenido a <span className="text-primary">YourTicket</span>
        </h1>
        <p className="lead text-muted">
          La plataforma líder para la compra de tickets electrónicos
        </p>
      </div>
      <div className="row">
        <div className="col-md-4">
          <div className="card mb-3 shadow-sm">
            <img src={exclusiveEvent} className="card-img-top" alt="Evento 1" />
            <div className="card-body">
              <h5 className="card-title">Eventos Exclusivos</h5>
              <p className="card-text">
                Accede a una gran variedad de eventos exclusivos desde
                conciertos, obras de teatro, y más.
              </p>
              <a href="#" className="btn btn-primary btn-sm">
                Ver Más
              </a>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card mb-3 shadow-sm">
            <img src={secureShopping} className="card-img-top" alt="Evento 2" />
            <div className="card-body">
              <h5 className="card-title">Compra Segura</h5>
              <p className="card-text">
                Compra tus tickets de manera rápida y segura, con múltiples
                opciones de pago.
              </p>
              <a href="#" className="btn btn-primary btn-sm">
                Ver Más
              </a>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card mb-3 shadow-sm">
            <img
              src={customerSupport}
              className="card-img-top"
              alt="Evento 3"
            />
            <div className="card-body">
              <h5 className="card-title">Soporte 24/7</h5>
              <p className="card-text">
                Nuestro equipo de soporte está disponible las 24 horas del día,
                los 7 días de la semana para ayudarte.
              </p>
              <a href="#" className="btn btn-primary btn-sm">
                Ver Más
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
