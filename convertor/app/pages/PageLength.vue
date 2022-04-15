<template>
  <Page>
    <ActionBar title="длина" />
    <StackLayout verticalAlignment="top">
      <convertor :ToDefault="ToDefault" :ToNeed="ToNeed" />
    </StackLayout>
  </Page>
</template>

<script>
import Convertor from "@/components/Convertor.vue";

export default {
  data() {
    return {
      ToDefault: {
        Сантиметры: function (val) {
          return val;
        },
        Метры: function (val) {
          return val * 100;
        },
        мили: function (val) {
          return val / 0.0000062137;
        },
      },
      ToNeed: {
        Сантиметры: function (val) {
          return val;
        },
        Метры: function (val) {
          return val / 100;
        },
        мили: function (val) {
          return val * 0.0000062137;
        },
      },
    };
  },
  components: {
    Convertor,
  },
};
</script>
