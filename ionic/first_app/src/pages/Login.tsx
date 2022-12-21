import { IonContent } from '@ionic/react'
import React from 'react'
import FormLogin from '../components/LoginUser'

type Props = {}

const Login = (props: Props) => {
  return (
    <IonContent className="ion-padding">
    <FormLogin />
    </IonContent>
  )
}

export default Login