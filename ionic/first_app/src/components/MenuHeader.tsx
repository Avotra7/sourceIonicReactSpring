import { IonHeader, IonToolbar, IonButtons, IonMenuButton, IonTitle } from '@ionic/react'
import React from 'react'

type Props = {}

const MenuHeader = (props: Props) => {
    return (
        <IonHeader>
            <IonToolbar>
                <IonButtons slot="start">
                    <IonMenuButton></IonMenuButton>
                </IonButtons>
                <IonTitle>Flotte_Vehicule</IonTitle>
            </IonToolbar>
        </IonHeader>
    )
}

export default MenuHeader