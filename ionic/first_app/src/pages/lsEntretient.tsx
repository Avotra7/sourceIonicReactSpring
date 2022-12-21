import { IonCard, IonContent, useIonAlert, useIonViewDidEnter, useIonViewWillEnter } from '@ionic/react'
import React, { useEffect } from 'react'
import { useHistory, useParams } from 'react-router';
import ListEntretien from '../components/ListEntretien';
import callApi from '../data/callApi';
import Entretien from '../model/Entretien';


const ListE =() => {
  const history=useHistory();
  const params = useParams<{ id: string }>();
  var [entretien,setEntretien]=React.useState<Entretien[]>([]);

  const getEntretien=()=>{
    fetch('http://webserviceflotteavion-production.up.railway.app/entretien/'+params.id, {       
        method:'GET',
        headers: {'Content-Type': 'application/json'},
    }).then(response => response.json())
    .then(data => setEntretien(data));
  }

  useEffect(() => {
    console.log(params.id);
    getEntretien();
  },[]);

  return (
    <IonContent className="ion-padding">
     <ListEntretien lsEntretient={entretien}/>
    </IonContent>
  );
}

export default ListE