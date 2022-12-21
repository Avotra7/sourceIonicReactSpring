import { Redirect, Route } from 'react-router-dom';
import { IonApp, IonButtons, IonContent, IonHeader, IonMenu, IonMenuButton, IonPage, IonRouterOutlet, IonTitle, IonToolbar, setupIonicReact } from '@ionic/react';
import { IonReactRouter } from '@ionic/react-router';


/* Core CSS required for Ionic components to work properly */
import '@ionic/react/css/core.css';

/* Basic CSS for apps built with Ionic */
import '@ionic/react/css/normalize.css';
import '@ionic/react/css/structure.css';
import '@ionic/react/css/typography.css';

/* Optional CSS utils that can be commented out */
import '@ionic/react/css/padding.css';
import '@ionic/react/css/float-elements.css';
import '@ionic/react/css/text-alignment.css';
import '@ionic/react/css/text-transformation.css';
import '@ionic/react/css/flex-utils.css';
import '@ionic/react/css/display.css';

/* Theme variables */
import './theme/variables.css';
import Login from './pages/Login';
import Header from './components/Header';
import Footer from './components/Footer';
import './assets/myappcss/App.css';
import Home from './pages/Home';
import Menu from './components/Menu';
import MenuHeader from './components/MenuHeader';
import InfiniteScrollExample from './components/InfiniteScrollExample';
import ShowVehicule from './pages/ShowVehicule';
import ListTrajet from './pages/ListTrajet';
import ShowAvion from './pages/ListAvion';
import ListE from './pages/lsEntretient';
import ShowAssuranceExp from './pages/ShowAssuranceExp';
setupIonicReact();

const App: React.FC = () => (
  <IonApp>
    <IonReactRouter>
      <IonRouterOutlet>    
        <Route path="/">
          <MenuHeader />
          <ShowAvion/>
        </Route>
        <Route path="/assuranceA">
          <ShowAssuranceExp/>
        </Route>
        <Route path="/entretien/:id">
          <MenuHeader />
          <ListE/>
        </Route>
        <Route path="/trajet">
          <MenuHeader />
          <ListTrajet/>
        </Route>
        <Route path="/login">
          <MenuHeader />
          <Login />
        </Route>
        <Route path="/home">
          <Menu />
          <IonPage id="main-content">
            <MenuHeader />
            <Home />
            <Footer />
          </IonPage>
        </Route>
        <Route path="/scroll">
          <InfiniteScrollExample />
        </Route>
      </IonRouterOutlet>
    </IonReactRouter>
  </IonApp>
);

export default App;
