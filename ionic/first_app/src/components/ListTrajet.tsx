import { IonContent, IonItem } from "@ionic/react";
import React from "react"
import Trajet from "../model/Trajet";
import TrajetItem from "./trajet";

interface ListTrajet{
    listT: Trajet[];
}

function ListTjt(listTrj:Trajet[]){
    const row =[];
    for(var i = 0;listTrj.length;i++){
        row.push(<IonItem>{TrajetItem({trj:listTrj[i]})}</IonItem>)
    }
    return row
}

const listTComp: React.FC<ListTrajet> = ({listT})=>{
    var listTrj = listT as Trajet[];
    return (
        <IonContent>
            {ListTjt(listTrj)}
        </IonContent>
    )
}


