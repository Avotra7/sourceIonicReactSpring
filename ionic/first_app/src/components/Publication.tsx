import { IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent } from '@ionic/react'
import React, { ReactNode } from 'react'

type Props = {
    title: string,
    datetime: string,
    text: string
}

const Publication = (props: Props) => {
  return (
    <IonCard>
      <IonCardHeader>
        <IonCardTitle>{props.title}</IonCardTitle>
        <IonCardSubtitle>{props.datetime}</IonCardSubtitle>
      </IonCardHeader>
      <IonCardContent>
        {props.text}
      </IonCardContent>
    </IonCard>
  )
}

export default Publication