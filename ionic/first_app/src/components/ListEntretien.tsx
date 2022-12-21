import { IonContent, IonItem} from "@ionic/react";
import Entretien from "../model/Entretien";
import React, { useEffect,useState } from "react";
import { useHistory } from "react-router";
import EntretienItem from "./Entretien";


interface ListEntretient{
    lsEntretient: Entretien[]
}

const ListEntretien: React.FC<ListEntretient> = ({lsEntretient})=>{
    const history=useHistory();
    const [LsEntretien,setLsEntretien]=useState<Entretien[]>([]);

    function verifyToken(data:any,entretien:Entretien){
        const tabdata=JSON.parse(JSON.stringify(data));
        console.log(tabdata.error);
        if(tabdata.error==undefined){
            history.push({pathname:'/entretien'});
            window.location.reload();

        }
        else{
            history.push('/login');
            window.location.reload();
        }
    }

    function TableView(LsEntretien:Entretien[],history:any){
        const rows:any =[];
        const tabjson=JSON.parse(JSON.stringify(LsEntretien)).data as [];
        if(tabjson !=undefined){
            for(var i=0;i<tabjson.length;i++){
                const entretien: Entretien=tabjson[i]as Entretien;
                rows.push(
                <IonItem> {EntretienItem({ entretien: entretien })}</IonItem>
                )
            }
        }
        return rows;
    }

    useEffect(()=>{
        setLsEntretien(lsEntretient as Entretien[]);
    })

    return (  
        <IonContent>
        {TableView(lsEntretient,history)}
        </IonContent>
    )
}
export default ListEntretien