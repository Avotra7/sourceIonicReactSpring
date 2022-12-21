import { IonButton, IonContent, IonItem,IonList, useIonViewWillEnter} from "@ionic/react";
import React, { ReactNode, useEffect, useState } from 'react'
import Personne from '../model/Personne'
import PersonneItem from './PersonneItem'
import getPersonne from '../data/PersonneData'
import Vehicule from "../model/Vehicule";
import VehiculeItem from "./VehiculeItem";
import { verify } from "crypto";
import { useHistory } from "react-router";

interface VehiculeTab{
    tabvehicule: Vehicule[]
}


const TabVehicule: React.FC<VehiculeTab> = ({tabvehicule})=>{
    const history=useHistory();
    const [perstab,setPerstab]=useState<Vehicule[]>([]);

    function verifyToken(data:any,vehicule:Vehicule){
        const tabdata=JSON.parse(JSON.stringify(data));
        console.log(tabdata.error);
        if(tabdata.error==undefined){
            history.push({pathname:'/trajet/'+vehicule.id,state:{detail:vehicule.listrajet}});
            window.location.reload();

        }
        else{
            console.log("oooo");
            history.push('/login');
            window.location.reload();
        }
    }
     
    
    function callApp(vehicule:Vehicule){
        const token=localStorage.getItem('token');
        const id=localStorage.getItem('id');
        const url='http://webserviceflotteavion-production.up.railway.app/trajet?idV='+vehicule.id+"&token="+token+"&id="+id;
        fetch(url, {       
            method:'GET',
            headers: {'Content-Type': 'application/json'},
        }).then(response => response.json())
        .then(data => verifyToken(data,vehicule));
    
    }
    
    
    
    function TableView(perstab:Vehicule[],history:any){
        const rows:any =[];
        const tabjson=JSON.parse(JSON.stringify(perstab)).data as [];
        if(tabjson !=undefined){
            for(var i=0;i<tabjson.length;i++){
                const vehicule: Vehicule=tabjson[i]as Vehicule;
                rows.push(
                <IonItem key={vehicule.id}>{VehiculeItem({ vehicule: vehicule })}
                <IonButton onClick={()=>callApp(vehicule)}>Voir Km</IonButton></IonItem>
                )
            }
        }
        return rows;
    }

    useEffect(()=>{
        setPerstab(tabvehicule as Vehicule[]);
    })

    return (  
        <IonContent>
        {TableView(tabvehicule,history)}
        </IonContent>
    )
}

export default TabVehicule;