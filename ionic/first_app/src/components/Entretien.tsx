import { IonItem,IonLabel, IonList } from "@ionic/react";
import React from "react";
import Entretien from "../model/Entretien";


interface Entretiens{
    entretien: Entretien
}

const EntretienItem : React.FC<Entretiens> = ({entretien}) => {
    
    return (
        <IonList>
            <IonItem>
            <IonLabel className="ion-text-wrap">
            <h2>{entretien.idAvion}</h2>
            <h2>{entretien.typeEntretien}</h2>
            <h2>{entretien.dateEntretien.toString()}</h2>
            </IonLabel>
            </IonItem>
        </IonList>
    )
}

export default EntretienItem;