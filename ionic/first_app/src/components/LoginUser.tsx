import { IonButton, IonInput, IonItem, IonLabel, useIonAlert } from "@ionic/react";
import { useRef, useState } from "react";
import { useHistory } from "react-router";

const FormLogin = () => {
    const history = useHistory();
    var logins = useRef<HTMLIonInputElement>(null);
    var mdp = useRef<HTMLIonInputElement>(null);
    const [presentAlert] = useIonAlert();
    const [userData,setUserData]=useState(null);
    
    function authentificate() {
        var username = logins.current?.value;
        var password = mdp.current?.value;
        getUserData(username,password);
        if(userData==undefined){
            presentAlert({
                header: 'Sign in failed',
                message: 'Invalid username or password',
                buttons: ['OK'],
            })
        }
        else{
            history.push('/show');
        }
    }


    function verifyData(data:any){
        const jsondata= data.data;
        if(data.data!=undefined){
            const token=data.data.token;
            const id=data.data.idutilisateur;
            localStorage.setItem('token',token);
            localStorage.setItem('id',id);
            return data.data;
        }
        return undefined;

    }

    const getUserData=(username:any,mdp:any)=>{
        fetch('http://webserviceflotteavion-production.up.railway.app/utilisateur', {       
            method:'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({logins:username,mdp:mdp})
        }).then(response => response.json())
        .then(data => setUserData(verifyData(data)));
      }
    
    return (
        <form className="ion-padding myform">
            <IonLabel className='formtitle'>Login Client</IonLabel>
            <IonItem className='inputitem'>
                <IonLabel position="floating">Username</IonLabel>
                <IonInput ref={logins} />
            </IonItem>
            <IonItem className='inputitem'>
                <IonLabel position="floating">Password</IonLabel>
                <IonInput ref={mdp} type="password" />
            </IonItem>
            <IonButton className="ion-margin-top inputitem" type="button" expand="block" onClick={authentificate}>
                Login
            </IonButton>
        </form>
    )
}

export default FormLogin