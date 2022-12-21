import { IonItem ,IonLabel} from "@ionic/react";
import React from "react";
import Vehicule from "../model/Vehicule";

interface V{
    vehicule: Vehicule
}

const VehiculeItem : React.FC<V> = ({ vehicule }) => {
    return(
            <IonLabel className="ion-text-wrap">
            <p><b>{vehicule.id}</b></p>

            <h2>
            {vehicule.marque}
            </h2>
            <h6>{vehicule.matricule}</h6>
            </IonLabel>
    )
}

export default VehiculeItem