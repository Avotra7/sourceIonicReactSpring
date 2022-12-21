import { IonContent, IonLabel } from "@ionic/react"
import React from "react"


import Assurance from "../model/Assurance"


interface A{
    assurance:Assurance
}

const AssuranceItem:React.FC<A> = ({assurance})=>{
    return (
        <IonLabel className="ion-text-wrap">
            <p>{assurance.mois}</p>
            <p>{assurance.id}</p>
             <p>{assurance.idAvion}</p>
            <h3>{assurance.datedebutassurance.toDateString()}</h3>
            <h3>{assurance.datefinassurance.toDateString()}</h3>

        </IonLabel>

    )

   
}
export default AssuranceItem 