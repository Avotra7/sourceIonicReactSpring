import {IonContent} from '@ionic/react'
import React, { useEffect } from 'react'
import { useHistory } from 'react-router';
import TabAssurance from '../components/TabAssurance';
import Assurance from '../model/Assurance';



const ShowAssuranceExp =() => {
  const history=useHistory();
  var [assurance,setAssurance]=React.useState<Assurance[]>([]);

 


  const getAssurance=()=>{
    fetch('http://localhost:8081/assuranceAvion/3', {       
        method:'GET',
        headers: {'Content-Type': 'application/json'},
    }).then(response => console.log(response.json()))
  }


  useEffect(() => {
    getAssurance();
  },[]);

  return (
    <IonContent className="ion-padding">
     <TabAssurance tabassurance={assurance}/>
    </IonContent>
  )
}

export default ShowAssuranceExp