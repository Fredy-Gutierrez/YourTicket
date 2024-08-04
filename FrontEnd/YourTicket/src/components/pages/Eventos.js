import React, { useState, useEffect } from "react";
import { getEvents } from "../../services/eventos-service";
import Card from "../common/Card";

const Eventos = () => {
  const [events, setEvents] = useState([]);
  useEffect(() => { 
      const loadEvents= async () => {
          const response = await getEvents();
          setEvents(response);
      };
      loadEvents(); 
  }, []);

  return (
    <div className="container">
      <h1>Eventos</h1>
      <div className="row">
        {
          events.map( event => (
              <Card carImg={`${process.env.PUBLIC_URL}/assets/${event.eventImg}`} cardTitle={event.eventName} cardText={event.information} action={`/compra/${event.eventID}`} className="col-lg-4 d-flex align-items-stretch" />
          ))
        }
      </div>
    </div>
  );
};

export default Eventos;
