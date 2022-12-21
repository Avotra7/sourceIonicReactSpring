import { IonContent, IonItem } from "@ionic/react";
import React from "react";
import { useState, useEffect } from "react";
import { Assurance } from "../model/Assurance"
import AssuranceItem from "./AssuranceItem";


interface tabA {

    tabassurance : Assurance[]
} 
function getAssurancelist(tabAssur:Assurance[]){

    const rows:any =[];
    const tabjson=JSON.parse(JSON.stringify(tabAssur)).data as [];
    if(tabjson !=undefined){
        for(var i=0;i<tabAssur.length;i++){
            const assurance: Assurance=tabjson[i]as Assurance;
         
            rows.push(<IonItem key={`assurance/${assurance.id}`} >{AssuranceItem({assurance})}</IonItem>);
        }
    }
    return rows;

}




const TabAssurance: React.FC<tabA> = ({tabassurance})=>{
    const [tabAssur,setPerstab]=useState<Assurance[]>([]);

    useEffect(()=>{
        setPerstab(tabAssur as Assurance[]);
    })

    return (  
        <IonContent>
        {getAssurancelist(tabassurance)}
        </IonContent>
    )
}



export default TabAssurance