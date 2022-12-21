import { IonMenu, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/react'
import React from 'react'

type Props = {}

const Menu = (props: Props) => {
    return (
        <IonMenu contentId="main-content">
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Menu Content({sessionStorage.getItem('user')!=null? "@user: "+JSON.parse(sessionStorage.getItem('user') as string).username:""})</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">Log Out</IonContent>
        </IonMenu>
    )
}

export default Menu