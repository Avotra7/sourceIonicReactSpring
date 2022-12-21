import { IonItem ,IonLabel, IonNote} from "@ionic/react";
import React from "react";
import Avion from "../model/Avion";

interface AV{
    avion: Avion
}

const VehiculeItem : React.FC<AV> = ({ avion }) => {
    return(

        <IonLabel className="ion-text-wrap">
            <h2><b>{avion.marque}</b></h2>
            <IonNote>{"Marque : "+avion.marque}</IonNote> 
            <br/>
            <span>
              <IonNote>{"NbPlace : "+avion.nbplace}</IonNote>
            </span>
        </IonLabel>

    )
}

export default VehiculeItem