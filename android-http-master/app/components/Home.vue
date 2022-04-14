<template>
  <Page>
    <ActionBar>
      <Label text="dollarPrice" />
    </ActionBar>

    <TabView
      height="100%"
      textFieldBackgroundColor="#07bb58"
      android-tabs-position="bottom"
      tab-text-font-size="16"
    >
      <TabViewItem title="Актеры">
        <StackLayout orientation="vertical" width="100%" height="100%">
            <FlexboxLayout class="card" v-for="(actor, index) in actors" :key="index" > 
                <Image 
                    width="70" 
                    height="70" 
                    class="card__image" 
                    :src="actor.img" 
                    stretch="fill" 
                />         
                <Label
                    width="150" height="70"
                    :text="actor.name"
                    class="card__title"
                />
            </FlexboxLayout>   
        </StackLayout>
      </TabViewItem>

      <TabViewItem title="список вопросов">
        <StackLayout orientation="vertical" width="100%" height="100%">
            <Label
                width="100%"
                :text="joke"
                class="card__title"
                text-wrap="true"

            />
             <Button text="другая шутка" @tap="getJoke" />
        
        </StackLayout>
      </TabViewItem>
      <TabViewItem title="Курс рубля к $">
        <StackLayout orientation="vertical" width="100%" height="100%">
            <FlexboxLayout class="card">      
                <Label
                    :text="courses.Name"
                    class="card__title"
                    text-wrap="true"
                />  
                <Label
                    :text="courses.Value"
                    class="card__title"
                    text-wrap="true"
                />  
            </FlexboxLayout>   
          <Button text="Обновить курс" @tap="getCourses" />
        </StackLayout>
      </TabViewItem>
    </TabView>
  </Page>
</template>

<script>

import { Http } from "@nativescript/core";

export default {
  data() {
    return {
      dollarPrice: { dollar: 2.81 },
      actors: [
          {
            img: '',
            name: ''
          }
      ],
      joke: '',
      courses: {
          Value: '',
          Name: ''
      },
    };
  },
  created() {
    this.getActors();
    this.getJoke();
    this.getCourses();
  },
  methods: {
    getActors() {
      Http.getJSON("https://www.breakingbadapi.com/api/characters/?limit=7")
        .then((response) => {
            this.actors = response
        })
        .catch((e) => {
          console.error(e);
        });
    },
    getJoke() {
      Http.getJSON("https://geek-jokes.sameerkumar.website/api?format=json")
        .then((response) => {
          this.joke = response.joke;
        })
        .catch((e) => {
          console.error(e);
        });
    },
    getCourses() {
      Http.getJSON("https://www.cbr-xml-daily.ru/daily_json.js")
        .then((response) => {
          this.courses = response.Valute.USD;
        })
        .catch((e) => {
          console.error(e);
        });
    },
  },
};
</script>

<style lang="scss">
Button {
  font-size: 12;
  font-weight: bold;
  color: white;
  background-color: #1a2c95;
  padding: 10;
  border-radius: 20px;
  margin-top: 50px;
}
.card {
    margin-bottom: 5px;
    margin-top: 5px;
    .card__image {
        margin-left: 5px;
    }
}
.card__title {
    padding-left: 40px;
    padding-top: 75px;
    font-weight: 600;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>