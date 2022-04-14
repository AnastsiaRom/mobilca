<script>
export default {
  props: ["ToDefault","ToNeed"],
  data() {
    return {
      baseValue: 0,
      valueInText: 0,
      firstType: 0,
      secondType: 1,
      resultConvert: 0,
    };
  },
  computed: {
    result() {
      return `= ${this.resultConvert}`;
    },
  },
  watch: {
    firstType(newVal) {
      this.firstType = newVal;
      this.calculate();
    },
    secondType(newVal) {
      this.secondType = newVal;
      this.calculate();
    },
    valueInText() {
      this.calculate();
    },
  },
  methods: {
    calculate() {
      const myFn1 = this.ToDefault[this.objToArryDefault()[this.firstType]];
      this.baseValue = myFn1(this.valueInText);
      this.testConvert = this.baseValue;

      const myFn2 = this.ToNeed[this.objToArryNeed()[this.secondType]];
      this.resultConvert = myFn2(this.baseValue);
    },
    objToArryNeed() {
      return Object.keys(this.ToNeed);
    },
    objToArryDefault() {
      return Object.keys(this.ToDefault);
    },
  },
};
</script>

<template>
  <StackLayout verticalAlignment="top">
    <GridLayout columns="*, *" rows="auto, auto">
      <ListPicker
        class="select-type"
        :items="objToArryNeed()"
        v-model="firstType"
        selectedIndex="0"
        row="0"
        col="0"
      />
      <ListPicker
        class="select-type"
        :items="objToArryDefault()"
        v-model="secondType"
        selectedIndex="1"
        row="0"
        col="1"
      />
    </GridLayout>
    <FlexboxLayout justifyContent="space-around" marginTop="30">
      <TextField
        :text="valueInText"
        v-model="valueInText"
        hint="0"
        width="33%"
      />
      <button class="button-transfer" @tap="reverse" text="⇆" width="33%" />
      <Label marginTop="30" :text="result" width="33%"></Label>
    </FlexboxLayout>
    <button @tap="$navigator.back()" text="Назад" marginTop="30" />
  </StackLayout>
</template>

<style lang="scss">
.select-type {
  background-color: rgb(219, 225, 230);
}
.result-field {
  color: black;
}
.button-transfer {
  width: 10%;
  border-radius: 50%;
}
</style>