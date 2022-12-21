import { IonFooter, IonToolbar, IonTitle, IonApp } from '@ionic/react'
import React from 'react'
import '../assets/myappcss/Footer.css'
type Props = {}

const Footer = (props: Props) => {
  return (
    <IonFooter>
      <IonToolbar>
        <IonTitle className='footertext'> First ionic react app by Ranja</IonTitle>
      </IonToolbar>
    </IonFooter>
  )
}

export default Footer