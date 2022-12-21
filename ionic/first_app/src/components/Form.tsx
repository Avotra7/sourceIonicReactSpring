import { IonButton, IonCheckbox, IonInput, IonItem, IonLabel, useIonAlert } from '@ionic/react'
import React, { useRef } from 'react'
import { useHistory } from 'react-router';
import '../assets/myappcss/Form.css';
type Props = {}

const Form = (props: Props) => {
    const history = useHistory();
    var logins = useRef<HTMLIonInputElement>(null);
    var mdp = useRef<HTMLIonInputElement>(null);
    const [presentAlert] = useIonAlert();
    
    function authentificate() {
        var username = logins.current?.value;
        var password = mdp.current?.value;
        presentAlert({
            header: 'Login Client',
            message: 'Username : '+username+' Password : '+password+'',
            buttons: ['OK'],
        })
      /*  var user = getUserData().find(x => x.username == username && x.password == password);
        if (user) {
            sessionStorage.setItem("user",JSON.stringify(user));
            history.push('/show');
        } else {
            presentAlert({
                header: 'Sign in failed',
                message: 'Invalid username or password',
                buttons: ['OK'],
            })
        }*/
    }
    
    return (
        <form className="ion-padding myform">
            <IonLabel className='formtitle'>Login Client</IonLabel>
            <IonItem className='inputitem'>
                <IonLabel position="floating">Username</IonLabel>
                <IonInput ref={logins} value="Jean" />
            </IonItem>
            <IonItem className='inputitem'>
                <IonLabel position="floating">Password</IonLabel>
                <IonInput ref={mdp} type="password" value="Jean"/>
            </IonItem>
            <IonButton className="ion-margin-top inputitem" type="button" expand="block" onClick={authentificate}>
                Login
            </IonButton>
        </form>
    )
}

export default Form