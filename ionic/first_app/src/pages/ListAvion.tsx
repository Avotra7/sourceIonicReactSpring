import { IonCard, IonContent, useIonAlert, useIonViewDidEnter, useIonViewWillEnter } from '@ionic/react'
import React, { useEffect } from 'react'
import { useHistory } from 'react-router';
import TabAvion from '../components/AvionList';
import AvionList from '../components/AvionList';
import TabVehicule from '../components/TabVehicule';
import callApi from '../data/callApi';
import Avion from '../model/Avion';

import Vehicule from '../model/Vehicule';


const ShowAvion =() => {
  const history=useHistory();
  var [avion,setAvion]=React.useState<Avion[]>([]);

  const getAvion=()=>{
    fetch('http://webserviceflotteavion-production.up.railway.app/avion', {       
        method:'GET',
        headers: {'Content-Type': 'application/json'},
    }).then(response => response.json())
    .then(data => setAvion(data));
  }

  useEffect(() => {
    getAvion();
  },[]);

  return (
    <IonContent className="ion-padding">
     <TabAvion tabavion={avion}/>
    </IonContent>
  )
}

export default ShowAvion