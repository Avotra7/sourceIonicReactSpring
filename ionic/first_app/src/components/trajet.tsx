import { IonItem,IonLabel, IonList } from "@ionic/react";
import React from "react";
import Trajet from "../model/Trajet";

interface Trj{
    trj: Trajet
}

const TrajetItem : React.FC<Trj> = ({trj}) => {
    return (
        <IonList>
            <IonItem>
            <IonLabel className="ion-text-wrap">
            <h2>{trj.idVehicule}</h2>
            <h2>{trj.debutkm}</h2>
            <h2>{trj.finkm}</h2>
            <h2>{trj.dates.toDateString()}</h2>
            </IonLabel>
            </IonItem>
        </IonList>
    )
}

export default TrajetItem