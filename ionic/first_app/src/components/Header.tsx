import { IonHeader, IonToolbar, IonTitle } from '@ionic/react'
import React from 'react'

type Props = {}

const Header = (props: Props) => {
  return (
    <IonHeader>
      <IonToolbar>
        <IonTitle>My Mini Social Media</IonTitle>
      </IonToolbar>
    </IonHeader>
  )
}

export default Header