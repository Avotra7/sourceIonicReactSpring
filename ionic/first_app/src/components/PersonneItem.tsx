import { IonItem ,IonLabel} from "@ionic/react";
import React from "react";
import Personne from "../model/Personne";

interface Pers{
    pers: Personne
}

const PersonneItem : React.FC<Pers> = ({ pers }) => {
    return(
            <IonLabel className="ion-text-wrap">
            <h2>
            {pers.nom}
            </h2>
            <p>{pers.prenom}</p>
            </IonLabel>
    )
}

export default PersonneItem