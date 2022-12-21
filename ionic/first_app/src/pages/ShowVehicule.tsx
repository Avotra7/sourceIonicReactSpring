import { IonCard, IonContent, useIonAlert, useIonViewDidEnter, useIonViewWillEnter } from '@ionic/react'
import React, { useEffect } from 'react'
import { useHistory } from 'react-router';
import TabVehicule from '../components/TabVehicule';
import callApi from '../data/callApi';

import Vehicule from '../model/Vehicule';


const z =() => {
  const history=useHistory();
  var [vehicule,setVehicule]=React.useState<Vehicule[]>([]);

  const getVehicule=()=>{
    fetch('http://webserviceflotteavion-production.up.railway.app/vehicule', {       
        method:'GET',
        headers: {'Content-Type': 'application/json'},
    }).then(response => response.json())
    .then(data => setVehicule(data));
  }

  useEffect(() => {
    getVehicule();
  },[]);

  return (
    <IonContent className="ion-padding">
     <TabVehicule tabvehicule={vehicule}/>
    </IonContent>
  )
}

export default z