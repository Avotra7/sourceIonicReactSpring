import { IonButton, IonCard, IonContent, IonIcon, IonItem,IonList, useIonViewWillEnter} from "@ionic/react";
import React, { ReactNode, useEffect, useRef, useState } from 'react'
import Personne from '../model/Personne'
import AvionItem from './AvionItem'
import getPersonne from '../data/PersonneData'
import Vehicule from "../model/Vehicule";
import VehiculeItem from "./VehiculeItem";
import {Camera,CameraResultType} from "@capacitor/camera";
import { verify } from "crypto";
import { useHistory } from "react-router";
import Avion from "../model/Avion";

interface AvionTab{
    tabavion: Avion[]
}


const TabAvion: React.FC<AvionTab> = ({tabavion})=>{
    const history=useHistory();
    const file=useRef(null);
    const [perstab,setPerstab]=useState<Avion[]>([]);
    const [img,setImg]=useState<any>();


    function verifyToken(data:any,avion:Avion){
        const tabdata=JSON.parse(JSON.stringify(data));
        console.log(tabdata.error);
        if(tabdata.error==undefined){
            history.push('/entretien/'+avion.id);
            window.location.reload();
        }
        else{
            history.push('/login');
            window.location.reload();
        }
    }
     
    
    function callApp(avion:Avion){
        let token=localStorage.getItem('token');
        let id=localStorage.getItem('id');
        if(id?.length==0){
            id="0";
        }
        const url='http://webserviceflotteavion-production.up.railway.app/token?user='+id+"&token="+token;
        console.log("url :"+url);

        fetch(url, {       
            method:'GET',
            headers: {'Content-Type': 'application/json'},
        }).then(response => response.json())
        .then(data => verifyToken(data,avion));
    
    }
    
    
    interface HTMLInputEvent extends Event {
        target : HTMLInputElement & EventTarget;
    }

    function sendMyImg(){
        console.log(img);
        let myFormData=new FormData();
        let airplanename=document.getElementById('filename')?.innerHTML;
        let myfile= new File([img],airplanename+".jpg");
        myFormData.append("File",img);
        const url='http://webserviceflotteavion-production.up.railway.app/avionimg';
        fetch(url, {       
            method:'POST',
            body: JSON.stringify(myFormData),
            headers: {'Content-Type': 'multipart/mixed;boundary=1000000'}
        }).then(response => response.json())
        .catch(e=>alert(e))
    }


    function base64toFile(base: string,filename:any){
        var arr= (base as string).split(',');
        let bstr=atob(arr[1]);
        let n=bstr.length;
        let u8arr=new Uint8Array(n);
        while(n--){
            u8arr[n]=bstr.charCodeAt(n);
        }
        return new File([u8arr],filename);
    }

    async function uploadImage(idV:number){
        let myFormData=new FormData();
        const test=await Camera.getPhoto({
            quality:90,
            allowEditing:true,
            resultType:CameraResultType.Base64
        })
        const url='http://webserviceflotteavion-production.up.railway.app/avionimg?id='+idV;
        fetch(url, {       
            method:'POST',
            headers: {'Content-Type': 'application/'},
            body:JSON.stringify({idavion:idV,img:test.base64String})
        }).then(response => response.json())
        .catch(e=>alert(e))        
        
    }

    function openFileDialog(){
        document.getElementById("file-upload")?.click();
    }
    
    function TableView(perstab:Avion[],history:any){
        const rows:any =[];
        const tabjson=JSON.parse(JSON.stringify(perstab)).data as [];
        if(tabjson !=undefined){
            for(var i=0;i<tabjson.length;i++){
                const avion: Avion=tabjson[i]as Avion;
                rows.push(
                <IonItem key={avion.id}>{AvionItem({ avion: avion })}
                <IonItem class="hide" id="filename">{avion.id}</IonItem>
                <IonButton onClick={()=>callApp(avion)}>Voir Details</IonButton>
                <IonButton onClick={()=>uploadImage(avion.id)}>
                    Photo
                </IonButton>
                </IonItem>
                )
            }
        }
        return rows;
    }

    useEffect(()=>{
        setPerstab(tabavion as Avion[]);
    })

    return (  
        <IonContent>
        {TableView(tabavion,history)}
        </IonContent>
    )
}

export default TabAvion;