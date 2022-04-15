<template>
  <Page>
    <ActionBar title="температура" />
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
        "Цельсий ℃": function (val) {
          return val;
        },
        "Фаренгейт ℉": function (val) {
          return (val - 32) / 1.8;
        },
      },
      ToNeed: {
        "Цельсий ℃": function (val) {
          return val;
        },
        "Фаренгейт ℉": function (val) {
          return val * 1.8 + 32;
        },
      },
    };
  },
  components: {
    Convertor,
  },
};
</script>
