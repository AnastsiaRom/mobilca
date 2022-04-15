<template>
  <Page>
    <ActionBar> </ActionBar>

    <StackLayout class="calendar-wrapper">
      <FlexboxLayout height="50" class="calendar-panel">
        <Button @tap="changeMouthLeft" text="<"></Button>
        <Label :text="curMouthName"></Label>
        <Button @tap="changeMouthRight" text=">"></Button>
      </FlexboxLayout>
        <FlexboxLayout height="50" class="calendar-weekdays">
          <Label
            v-for="(dayWeek, index) in dayWeeks"
            :text="dayWeek"
            :key="index"
            width="44"
            height="44"
          ></Label>
        </FlexboxLayout>

      <FlexboxLayout height="auto" class="calendar-days">
        <Label
          v-for="(day, index) in arrDayMouth"
          :text="day"
          :key="index"
        :style="{
            'background-color': nowDay(day)
        }"
          width="44"
          height="44"
        ></Label>
      </FlexboxLayout>
    </StackLayout>
  </Page>
</template>

<script>
export default {
  data() {
    return {
      nowDate: new Date(),
      nowDateNumber: new Date().getDate(),
      nowMonth: new Date().getMonth(),
      nowYear: new Date().getFullYear(),
      monthName: [
        "январь",
        "февраль",
        "март",
        "апрель",
        "май",
        "июнь",
        "июль",
        "август",
        "сентябрь",
        "октябрь",
        "ноябрь",
        "декабрь",
      ],
      dayWeeks: ["пн", "вт", "ср", "чт", "пт", "сб", "вс"],
      curMouthName: "",
      curCountDays: [],
      dayCountMouth: 0,
      arrDayMouth: [],
    };
  },
  created() {
    this.setCurCountDays();
    this.setCurMouth();
  },
  methods: {
    setCurCountDays() {
        this.arrDayMouth = [];
      this.dayCountMouth = new Date( this.nowYear, this.nowMonth + 1,0).getDate();
      let dayCountMouthLeft = new Date(this.nowYear,this.nowMonth,0).getDate();
      let dayWeekMouth = new Date(this.nowYear, this.nowMonth, 0).getDay()  ;
        dayWeekMouth = [7, 1, 2, 3, 4, 5, 6][dayWeekMouth]
      for (let i = dayCountMouthLeft+ 1 - dayWeekMouth ;i <= dayCountMouthLeft;i++) {
        this.arrDayMouth.push(i);
      }
      for (let i = 1; i <= this.dayCountMouth; i++) {
        this.arrDayMouth.push(i);
      }
    },
    setCurMouth() {
      this.curMouthName = this.monthName[this.nowMonth];
    },
    changeMouthLeft() {
      if (this.nowMonth == 0) {
        this.nowYear = this.nowYear - 1;
        this.nowMonth = 11;
      } else {
        this.nowMonth = this.nowMonth - 1;
      }
      this.setCurMouth();
      this.setCurCountDays();
    },
    changeMouthRight() {
      if (this.nowMonth == 11) {
        this.nowYear = this.nowYear + 1;
        this.nowMonth = 0;
      } else {
        this.nowMonth = this.nowMonth + 1;
      }
      this.setCurMouth();
      this.setCurCountDays();
    },
    nowDay(val) {
        if(val === this.nowDateNumber && this.nowMonth === new Date().getMonth()){
            return "green"
        }
            return "white"

    }
  },
  computed: {},
};
</script>

<style scoped lang="scss">
.calendar-panel {
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
}

.calendar-days {
  width: 100%;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-content: flex-start;
  Label {
    text-align: center;
    padding-top: 36px;
    margin-left: 10px;
    margin-bottom: 15px;
    border-radius: 10%;
  }
}
.calendar-weekdays {
  justify-content: flex-start;
  background-color: #e2e1e1;
  margin-bottom: 20px;
  Label {
    text-align: center;
    padding-top: 46px;
    margin-left: 10px;
    margin-bottom: 15px;
    border-radius: 50%;
    color: rgb(36, 31, 31);
  }
}
.calendar-panel__mounth {
  padding-top: 18px;
  text-align: center;
  font-weight: 600;
}
.calendar-wrapper {
  width: 90%;
  height: 80%;
  box-shadow: 0px 6px 37px rgba(109, 67, 90, 0.1);
  border-radius: 15px;
  margin-top: 50px;
  padding: 15px;
}
</style>
