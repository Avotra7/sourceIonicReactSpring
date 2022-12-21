import { IonContent, IonItem,IonList, useIonViewWillEnter} from "@ionic/react";
import React, { ReactNode, useState } from 'react'
import Personne from '../model/Personne'
import PersonneItem from './PersonneItem'
import getPersonne from '../data/PersonneData'

interface PersTab{
    tabpers: Personne[]
}

function TableView(perstab:Personne[]){
    const rows=[];
    for(var u=0; u<perstab.length;u++){
        rows.push(<IonItem routerLink={`${perstab[u].id}`}>{PersonneItem({pers:perstab[u]})}</IonItem>);          
    }
    return rows;
}


const TabPersonneComp: React.FC<PersTab> = ({tabpers})=>{
    var perstab=tabpers as Personne[];
    return (  
        <IonContent>
        {TableView(perstab)}
        </IonContent>
    )
}

export default TabPersonneComp;