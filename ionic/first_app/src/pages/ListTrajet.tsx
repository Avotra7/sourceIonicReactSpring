import { IonContent } from "@ionic/react"
import { useEffect } from "react";
import { useHistory, useLocation } from "react-router"
import Trajet from "../model/Trajet";

const ListTrajet=()=>{
    const history=useHistory();
    const location=useLocation<Trajet[]>();
    return(
        <IonContent></IonContent>
    )
}

export default ListTrajet