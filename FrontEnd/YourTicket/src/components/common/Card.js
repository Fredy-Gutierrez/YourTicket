import React from "react";
import {Link} from "react-router-dom";
import  "./Card.css"


const Card = ({carImg, cardTitle, cardText, action, className}) => {
  return (
    <div className={className}>
        <div className="card mb-3 shadow-sm">

            <img className="card-img-top" src={carImg} alt={cardTitle}/>

            <div className="card-body">
                <h5 className="card-title">{cardTitle}</h5>
                <p className="card-text">
                {cardText}
                </p>

                <Link to={action} className="btn btn-primary btn-sm btn-card"> Ver Más </Link>
            </div>
        </div>
    </div>
  );
};

export default Card;