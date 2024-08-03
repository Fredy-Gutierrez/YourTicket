import React, { useState, useEffect } from "react";
import { getEvent, getZones } from "../../services/eventos-service";
import {useParams} from "react-router-dom";

const Buy = () => {
    const params = useParams();
    const eventId = params.eventid;
    const userData = JSON.parse(localStorage.getItem("userData"));

    const [event, setEvent] = useState([]);
    useEffect(() => { 
        const loadEvent= async () => {
            const response = await getEvent(eventId);
            setEvent(response);
        };
        loadEvent(); 
    }, [eventId]);

    //https://www.tutorialesprogramacionya.com/reactya/detalleconcepto.php?punto=21&codigo=21&inicio=20


    const [zones, setZones] = useState([])
    const [zoneSelected, setZoneSelected] = useState({})
    useEffect(() => {
        const loadZones= async () => {
            const response = await getZones(eventId);
            setZones(response);
            setZoneSelected(response[0]);
        };
        loadZones(); 
    }, [eventId])

    // const [articulosRubro, setarticulosRubro] = useState([])
    // const [articuloSeleccionado, setArticuloSeleccionado] = useState([])
    // useEffect(() => {
    //     if (rubroSeleccionado.codigo)
    //     fetch('https://www.scratchya.com.ar/reactya/proyecto021/recuperararticulos.php?rubro=' + rubroSeleccionado.codigo)
    //         .then((response) => {
    //         return response.json()
    //         })
    //         .then((art) => {
    //         setarticulosRubro(art)
    //         setArticuloSeleccionado(art[0])
    //         })
    // }, [rubroSeleccionado])



    function changeZone(e) {
        const zoneSelected = zones.find(z => Number.parseInt(z.zoneID) === Number.parseInt(e.target.value))
        setZoneSelected(zoneSelected)
    }

    // function cambiarArticulo(e) {
    //     setArticuloSeleccionado(articulosRubro.find(articulo => Number.parseInt(articulo.codigo) === Number.parseInt(e.target.value)))
    // }
    
    return (
      <div className="container">

        <div className="col-md-12  d-flex justify-content-center">
            <h1>Evento {event.eventName}  </h1>
        </div>

        <div className="col-md-12 d-flex justify-content-center">
            <form className="col-md-10">

                <div className="form-group p-2">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
                    <small id="emailHelp" className="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div className="form-group p-2">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" className="form-control" id="exampleInputPassword1" placeholder="Password" />
                </div>
                <button type="submit" className="btn btn-primary ">Submit</button>
            </form>
        </div>
        
      </div>
    );
  };

  export default Buy;
