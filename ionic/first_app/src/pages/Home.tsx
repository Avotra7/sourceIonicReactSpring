import { IonContent, IonFooter, IonInfiniteScroll, IonInfiniteScrollContent, IonToolbar, isPlatform, useIonViewWillEnter } from '@ionic/react';
import React, { useState } from 'react'
import Menu from '../components/Menu';
import Publication from '../components/Publication'

type Props = {}

const Home = (props: Props) => {
    const [isInfiniteDisabled, setInfiniteDisabled] = useState(false);
    const [publications, setPublications] =useState<Publication[]>([]);

    type Publication = {
        title: string,
        datetime: string,
        text: string
    }
    const staticdata=[
        { title: "Ranja", datetime: "2022-01-14 13:30", text: "Bonjour les amis" },
        { title: "Jean", datetime: "2022-01-01 15:20", text: "Au revoir les amis" },
        { title: "Paul", datetime: "2022-02-01 08:14", text: "Ça va les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" },
        { title: "Thierry", datetime: "2023-04-15 18:44", text: "C'est bien les amis" }
    ]
    const pushData = () => {
        if(publications.length===staticdata.length){
            setInfiniteDisabled(true);
        }
        const max = publications.length + 10;
        const min = max - 10;
        const newData = [];
        for (let i = min; i < max; i++) {
            if(staticdata[i]==null || staticdata[i]==undefined){
                continue;
            }
          newData.push(staticdata[i]);
        }
        
        setPublications([
          ...publications,
          ...newData
        ]);
      }
      const loadData = (ev: any) => {
        setTimeout(() => {
          pushData();
          console.log('Loaded data');
          ev.target.complete();
        }, 500);
      }  
      
      useIonViewWillEnter(() => {
        pushData();
      });
    return (
        <>
            <IonContent className="ion-padding">

                {publications.map((publication: Publication, index: number) => <Publication key={index} title={publication.title} datetime={publication.datetime} text={publication.text} />
                )}
                <IonInfiniteScroll
                    onIonInfinite={loadData}
                    threshold="100px"
                    disabled={isInfiniteDisabled}
                >
                    <IonInfiniteScrollContent
                        loadingSpinner="bubbles"
                        loadingText="Loading more data..."
                    ></IonInfiniteScrollContent>
                </IonInfiniteScroll>
            </IonContent>
        </>
    )
}

export default Home